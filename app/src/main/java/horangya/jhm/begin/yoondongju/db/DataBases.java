package horangya.jhm.begin.yoondongju.db;

import android.provider.BaseColumns;

public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String POEMTITLE = "poemTitle";
        public static final String POEMTEXT = "poemText";
        public static final String POEMWRITER = "poemWriter";
        public static final String USERTITLE = "userTitle";
        public static final String USERWRITER = "userWriter";
        public static final String USERTEXT = "userText";
        public static final String _TABLENAME0 = "POEM";
        public static final String NI_DATE = "niDate";
        public static final String LS_DATE = "lsDate";
        public static final String _ID = "id";


        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" text primary key, "
                +POEMTITLE+" text not null , "
                +POEMWRITER+" text not null , "
                +POEMTEXT+" text not null , "
                +USERTITLE+" text  , "
                +USERWRITER+" text  , "
                +USERTEXT+" text  , "
                +NI_DATE+" text  , "
                +LS_DATE+" text  );";
    }
}