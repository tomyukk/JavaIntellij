package laba2;

import java.util.ArrayList;
import java.util.List;
import laba2.Book;

public class BookBuilder {
    private String name;
    private List<String> authours = new ArrayList<String>();
    private String publish;
    private int year;
    private int cntPage;
    private Book ob;
    public void setName(String name)throws RuntimeException {
        if(ob.checkName(name))
            this.name = name;

        throw new RuntimeException("Incorect book name!");
    }

    public void setAuthours(List<String> authours)throws RuntimeException {
        int i;
        for(i=0;i<authours.size();i++)
            if(ob.checkAthours(authours.get(i)));
            else
                throw new RuntimeException("Incorect authours name!");
        this.authours = authours;
    }


    public void setPublish(String publish)throws RuntimeException {
        if(ob.checkPublish(publish))
            this.publish = publish;
        throw new RuntimeException("Incorect publish name!");
    }



    public BookBuilder setYear(int year) throws RuntimeException {
        if(year<0)
            throw new RuntimeException("Negative year is impossible!");
        this.year = year;
        return this;
    }

    public BookBuilder setCntPage(int cntPage)throws RuntimeException {
        if(cntPage<0)
            throw new RuntimeException("Negative count of page is impossible!");
        this.cntPage = cntPage;
        return this;
    }



}
