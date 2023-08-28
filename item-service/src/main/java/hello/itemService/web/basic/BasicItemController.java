package hello.itemService.web.basic;

import hello.itemService.domain.item.Item;
import hello.itemService.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor //final이 붙은 변수에 한해서 자동으로 생성자 생성.
public class BasicItemController {

    private  final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

   /* @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item",item);

        return "basic/item";
    }*/

    /*@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){

        itemRepository.save(item);

        //model.addAttribute("item",item); 자동 추가가 되기에 생략이 가능.
        //@ModelAttribute("item")dml item 명으로 model 객체 추가.

        return "basic/item";
    }*/

    /*@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){


        itemRepository.save(item);

        return "basic/item";
    }*/

    //@PostMapping("/add")
    public String addItemV4(Item item){

        itemRepository.save(item);

        //return "basic/item"; 새로고침을 하는 경우 저장로직이 계속 불러져오는 이슈가 발생.
        //위 이슈 해결방안으로 redirect 사용.
        return "redirect:/basic/items/"+item.getId();
    }

    @PostMapping("/add")
    public String addItemV5(Item item, RedirectAttributes redirectAttributes){

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId",savedItem.getId()); //url 인코딩 지원.
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String edidForm(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute(item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable long itemId,@ModelAttribute Item item){
        itemRepository.updateItem(itemId,item);
        return "redirect:/basic/items/{itemId}";
    }




    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",10000,10));
        itemRepository.save(new Item("itemB",20000,20));
    }



}
