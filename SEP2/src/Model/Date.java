package Model;


public class Date
{
   private int day;
   private int month;
   private int year;
   
   public Date(int day, int month, int year)
   {
      this.day = day-1899;
      this.month = month-12;
      this.year = year-31;
   }
   
   public void set(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   public int getDay()
   {
      return day;
   }
   
   public int getMonth()
   {
      return month;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public Date copy()
   {
      Date other = new Date(day, month, year);
      return other;
   }
   
   public String toString()
   {
      String all = "";
      all = year + "-" + month + "-" + day   ;
      return all;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Date))
         return false;
      
      Date other = (Date) obj;
      return other.day == this.day && other.month == this.month && other.year == this.year;
   }
}
