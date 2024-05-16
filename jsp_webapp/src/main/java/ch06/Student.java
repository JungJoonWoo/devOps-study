package ch06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private int id;
  private String username;
  private String univ;
  private Date birth;
  private String email;

}
