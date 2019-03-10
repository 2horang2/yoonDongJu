package horangya.jhm.begin.yoondongju;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

import horangya.jhm.begin.yoondongju.db.DbOpenHelper;
import horangya.jhm.begin.yoondongju.dummy.Poem;

import static horangya.jhm.begin.yoondongju.Utils.backInt;
import static horangya.jhm.begin.yoondongju.Utils.backList;
import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;

public class TextActivity extends AppCompatActivity {


    public static final String TITLE_TRANSITION_NAME = "title";
    public static final String TEXT_TRANSITION_NAME = "text";
    public static final String VIEW = "view";

    EditText userTextD;
    EditText userTitleD ,poemTitleD;
    EditText userWriterD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        try{
            if(typeface == null) {
                typeface = Typeface.createFromAsset( getAssets(),
                        "Mohave.ttf");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setGlobalFont( getWindow().getDecorView());

        RelativeLayout view = (RelativeLayout)findViewById(R.id.view);

        final TextView ratio = (TextView)findViewById(R.id.ratio);
        final EditText poemText = (EditText)findViewById(R.id.poemText);
        final EditText userText = (EditText)findViewById(R.id.userText);
        EditText poemTitle = (EditText)findViewById(R.id.poemTitle);
        EditText poemWriter = (EditText)findViewById(R.id.poemWriter);
        userWriterD  = (EditText)findViewById(R.id.userWriter);
        userTitleD = (EditText)findViewById(R.id.userTitle);
        userTextD = (EditText)findViewById(R.id.userText);
        poemTitleD = (EditText)findViewById(R.id.poemTitle);


        final ConstraintLayout container = (ConstraintLayout)findViewById(R.id.container);

        container.setBackground(backList.get(backInt));

        ViewCompat.setTransitionName(poemTitle, TITLE_TRANSITION_NAME);
        ViewCompat.setTransitionName(poemText, TEXT_TRANSITION_NAME);
        ViewCompat.setTransitionName(view, VIEW);

        poemTitle.setText( getIntent().getStringExtra("title") );
        poemWriter.setText( getIntent().getStringExtra("writer") );
        poemText.setText( getIntent().getStringExtra("text") );
        userText.setText( getIntent().getStringExtra("userText") );

        int poemTextCnt = poemText.getText().length();
        int userTextCnt = userText.getText().length();
        ratio.setText( userTextCnt + " / " + poemTextCnt +" 글자");

        userText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                int poemTextCnt = poemText.getText().length();
                int userTextCnt = userText.getText().length();
                ratio.setText( userTextCnt + " / " + poemTextCnt +" 글자");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int poemTextCnt = poemText.getText().length();
                int userTextCnt = userText.getText().length();
                ratio.setText( userTextCnt + " / " + poemTextCnt +" 글자");
                Log.i("textaaaa",userTextCnt + " / " + poemTextCnt +" 글자");

                if(poemTextCnt == userTextCnt){
                    container.setDrawingCacheEnabled(true);



                    Bitmap captureBitmap = container.getDrawingCache(); // 캡쳐



                    // 캡쳐하기

                    screenshot(captureBitmap);



                    // 비트맵 불러오기

                    try {



                        SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
                        String date = dfDate.format(new java.util.Date());
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "YUNDONGJU"); // 폴더 경로

                        String strFilePath = String.format("%s/%s_%s.png",file, getIntent().getStringExtra("title"), date);
Log.i("aaaaaaaaaaaaaaaaa_read",strFilePath);
                        Intent intent = new Intent(getApplicationContext(),PoemDialog.class);
                        intent.putExtra("filePath",strFilePath);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "저장 성공", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {

                        Toast.makeText(getApplicationContext(), "저장 실패ㅠ_ㅠ", Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    public void screenshot(Bitmap captureBitmap) {

        FileOutputStream fos = null;
        try {
            String rootPath = Environment.getExternalStorageDirectory().toString();
            File root = new File(rootPath + "/Capture");
            root.mkdirs();
        }catch (Exception e){
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "YUNDONGJU"); // 폴더 경로
        if (!file.exists()) {  // 해당 폴더 없으면 만들어라
            file.mkdirs();
        }
        Log.i("aaaaaaaaaaaaaaaa_write2",file.toString());

        SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        String date = dfDate.format(new java.util.Date());

        String strFilePath = String.format("%s/%s_%s.png", file, getIntent().getStringExtra("title"), date);

        Log.i("aaaaaaaaaaaaaaaaa_write",strFilePath);

        File fileCacheItem = new File(strFilePath);
        try {
            fos = new FileOutputStream(fileCacheItem);
            captureBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed(){
        SaveDialog saveDialog = new SaveDialog(TextActivity.this);
        saveDialog.show();
    }

    public class SaveDialog extends Dialog {

        public SaveDialog(@NonNull Context context){
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_save_dialog);

            try{
                if(typeface == null) {
                    typeface = Typeface.createFromAsset( getAssets(),
                            "Mohave.ttf");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            setGlobalFont( getWindow().getDecorView());

            findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TextActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });
            findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                    String date = dfDate.format(new java.util.Date());

                    DbOpenHelper mDbOpenHelper = new DbOpenHelper(TextActivity.this);
                    mDbOpenHelper.open();
                    Poem item = new Poem();
                    item.setPoemTitle(poemTitleD.getText().toString());
                    item.setUserText(userTextD.getText().toString());
                    item.setUserTitle(userTitleD.getText().toString());
                    item.setUserWriter(userWriterD.getText().toString());
                    item.setDate(date);
                    mDbOpenHelper.updateColumn(item);
                    mDbOpenHelper.close();

                    //setPoem();
                    Intent intent = new Intent(TextActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
