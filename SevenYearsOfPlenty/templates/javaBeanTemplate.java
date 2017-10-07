/*
 * This is a template for net beans
 */

import java.io.Serializable;

public class SomeClass implements Serializable {

    private double someAttrib01;
    private String someAttrib02;

    public SomeClass() {}

    public double getSomeAttrib01()
    {
        return someAttrib01;
    }

    public void setSomeAttrib01(double someAttrib01)
    {
        this.someAttrib01 = someAttrib01;
    }

    public String getSomeAttrib02()
    {
        return this.someAttrib02;
    }

    public void setSomeAttrib02(String someAttrib02)
    {
        this.someAttrib02 = someAttrib02;
    }
}
