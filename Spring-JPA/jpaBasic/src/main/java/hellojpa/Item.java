package hellojpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

}


// InheritanceType.JOINED = 조인 전략. 상속 클래스마다 테이블 생성 및 부모 클래스 테이블에 구분 컬럼 추가. 실무에서 자주 사용.
// InheritanceType.SINGLE_TABLE = 싱글테이블 전략. 하나의 테이블로 관리.
// InheritanceType.TABLE_PER_CLASS = 구현 클래스마다 테이블 생성 전략. 실무에서 선호하지 않고 사용하지 않음.