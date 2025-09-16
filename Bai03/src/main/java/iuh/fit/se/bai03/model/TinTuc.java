package iuh.fit.se.bai03.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class TinTuc {
    @Id
    private String maTT;
    private String tieuDe;
    private String noiDungTT;
    private String lienKet;
    private int maDM;

}
