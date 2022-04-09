package com.example.mohamedkaipally_comp304_003_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondPage extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3,cb4;
    private Button nextButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        cb1= (CheckBox) findViewById(R.id.checkBox);
        cb2= (CheckBox) findViewById(R.id.checkBox2);
        cb3= (CheckBox) findViewById(R.id.checkBox3);
        cb4= (CheckBox) findViewById(R.id.checkBox4);

        imageView = (ImageView)findViewById(R.id.imageviewforline);
        nextButton=(Button) findViewById(R.id.btNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();

                if(cb1.isChecked()){
                    result.append("\n"+cb1.getText().toString());
                }
                if(cb2.isChecked()){
                    result.append("\n"+cb2.getText().toString());
                }
                if(cb3.isChecked()){
                    result.append("\n"+cb3.getText().toString());
                }
                if(cb4.isChecked()){
                    result.append("\n"+cb4.getText().toString());
                }
                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()){
                    result.append("\nNone");
                }
                Toast.makeText(SecondPage.this,result,Toast.LENGTH_SHORT).show();
            }
        });

        Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imageView.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(10);

        canvas.drawLine(0,0,imageView.getWidth(),imageView.getHeight(),paint);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);

    }
}