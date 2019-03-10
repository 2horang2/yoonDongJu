package horangya.jhm.begin.yoondongju;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;

public class PoemDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_dialog);

        try{
            if(typeface == null) {
                typeface = Typeface.createFromAsset( getAssets(),
                        "Mohave.ttf");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setGlobalFont( getWindow().getDecorView());

        this.setFinishOnTouchOutside(true);

        ImageView imageView = findViewById(R.id.imgView);
        final String imgpath = getIntent().getStringExtra("filePath"); // 비트맵 저장 경로
        Bitmap bm = BitmapFactory.decodeFile(imgpath);
        imageView.setImageBitmap(bm);

        TextView share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/png");
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(imgpath));
                startActivity(Intent.createChooser(share, "작품 공유"));

            }
        });
    }
}
