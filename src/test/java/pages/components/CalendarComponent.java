package pages.components;

import static com.codeborne.selenide.Selenide.$;
// 1 ... 28
// '1fsrf'5, '', 'wefew13', '28'
// length() - count of symbols in String object
public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + (day.length() == 2 ? day : ("0"+day))).click();

    }
}
