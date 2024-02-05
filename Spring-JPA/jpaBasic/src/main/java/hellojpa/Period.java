package hellojpa;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter @Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
