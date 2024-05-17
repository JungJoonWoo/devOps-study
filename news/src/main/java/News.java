import lombok.*;

import java.sql.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class News {
  private int aid;
  private String title;
  private String img;
  private Date date;
  private String content;
}
