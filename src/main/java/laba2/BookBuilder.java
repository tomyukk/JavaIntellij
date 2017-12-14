package laba2;

import java.time.Year;
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

    public int getCurrentYear(){
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }

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
        if(year>1950 && year<getCurrentYear() )
            throw new RuntimeException("Negative year is impossible!");
        this.year = year;
        return this;
    }

    public BookBuilder setCntPage(int cntPage)throws RuntimeException {
        if(cntPage<0 && cntPage>3000)
            throw new RuntimeException("Negative count of page is impossible!");
        this.cntPage = cntPage;
        return this;
    }



}
