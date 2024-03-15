package day9.chapter7.Ex2;

public interface Delicious extends Edible, Sweatable{

}
interface Edible {
  void eat();
}

interface Sweatable {
  void sweat();
}