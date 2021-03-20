package by.belstu.it.kovalev;

import java.util.Objects;

/** Класс WrapperString для замены и удаления символов из строки
 * @author Ковалев Александрв
 *  @version 1.1*/
public class WrapperString {
    private String str;

    public WrapperString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }
    public IReplace aclass = new IReplace()
    {
        public void replace (char oldchar, char newchar)
        {
            str.replace(oldchar,newchar);
        }

        public void delete (char newchar)
        {
            str.replace(newchar,' ');
        }
    };

}
