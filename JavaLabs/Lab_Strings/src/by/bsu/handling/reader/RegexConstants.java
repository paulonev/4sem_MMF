package by.bsu.handling.reader;

public class RegexConstants {
    public static final String MATH_REGEX = "(?:[\\d+/*()]|sin\\(|cos\\(|Pi|\\-(?!\\p{Blank}|$)|\\.(?=\\d))+(?!\\w)";
    //цифра или /, или *, или (, или ), или sin, или cos, или Pi, или -, но впереди нет
    //(Пробел или табуляция или конец строки или любые символы =цифра)один или более раз, нет буквенных слов
    public static final String PARAGRAPH_REGEX = "\\s{4,}"; //4 or more blank spaces

    public static final String SENTENCE_REGEX = "(?:[^!?.]|\\.(?=\\d))+[!?.]";//предложение содержащее цифры
    public static final String LEXEME_SPLITERATOR = "\\S+";//пробельные символы, встречающиеся 1 и более раз
}
