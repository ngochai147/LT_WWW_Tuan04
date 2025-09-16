package iuh.fit.se.bai03.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DanhMuc {
    @Id
    private int maDM;
    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;

}
