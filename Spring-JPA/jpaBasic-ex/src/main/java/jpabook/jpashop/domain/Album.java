package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter @Setter
public class Album extends Item{

    private String artist;
    private String etc;

}
