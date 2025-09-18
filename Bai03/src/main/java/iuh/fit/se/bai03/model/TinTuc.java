package iuh.fit.se.bai03.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Mã tin tức không được rỗng")
    private String maTT;
    @NotBlank(message = "Tiêu đề không được rỗng")
    private String tieuDe;
    @NotBlank(message = "Nội dung không được rỗng")
    @Size(max = 255,message = "Nội dung không quá 255 ký tự")
    private String noiDungTT;

    @NotBlank(message = "Liên kết không được rỗng")
    @Pattern(regexp = "^http://.*",message = "Liên kết bắt đầu bởi:'http://'")
    private String lienKet;
    private int maDM;

}
