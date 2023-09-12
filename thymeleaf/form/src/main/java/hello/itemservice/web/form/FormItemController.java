package hello.itemservice.web.form;

import hello.itemservice.domain.item.DeliberyCode;
import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.domain.item.ItemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/form/items")
@RequiredArgsConstructor
public class FormItemController {

    private final ItemRepository itemRepository;

    @ModelAttribute("regions") // = model.addAttribute("regions", regions);
    public Map<String, String> regions(){
        Map<String, String> regions = new LinkedHashMap<>();
        //linkedHashMap을 사용하는 이유는 넣는 순서를 유지하기 위함. hashMap은 순서 유지가 되지 않음.

        regions.put("seoul","서울");
        regions.put("busan","부산");
        regions.put("jeju","제주");

        return regions;
    }

    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes(){
        return ItemType.values();
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "form/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());

        return "form/addForm";
    }

    @ModelAttribute("deliveryCodes")
    public List<DeliberyCode> deliberyCodes(){
        List<DeliberyCode> deliberyCode = new ArrayList<>();
        deliberyCode.add(new DeliberyCode("FAST", "빠른배송"));
        deliberyCode.add(new DeliberyCode("NORMAL", "일반배송"));
        deliberyCode.add(new DeliberyCode("SLOW", "느린배송"));

        return deliberyCode;
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {

        log.info("item.open={}",item.getOpen());
        log.info("item.regions={}",item.getRegions());
        log.info("item.itemType={}",item.getItemType());

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/form/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "form/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/form/items/{itemId}";
    }

}

