package com.example.pritampc.foodappui;


import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.test.mock.MockApplication;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {
    ImageView back_img, extra_but;
    View Hide_layout;
    RelativeLayout design_layout;
    TextView order,delivery,contact,title;
    CircularAnimator anim = new CircularAnimator(MainActivity.this);
    private static final String TAG = "MAIN";
    private boolean open=false;
    Toolbar cus_toolbar;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hide_layout = findViewById(R.id.layhide);
        extra_but = findViewById(R.id.extra_but);
        //back_img = findViewById(R.id.back_img);
        order=findViewById(R.id.order_place);
        delivery=findViewById(R.id.delivery);
        contact=findViewById(R.id.Contact);
        design_layout =findViewById(R.id.design);
        title=findViewById(R.id.title);
        Typeface tf=Typeface.createFromAsset(getAssets(), "fonts/belli.ttf");
        order.setTypeface(tf);
        delivery.setTypeface(tf);
        contact.setTypeface(tf);
        title.setTypeface(tf);
        //final Drawable drawable=back_img.getBackground();
        //.setAlpha(0);
        extra_but.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                /*Display mdisp=getWindowManager().getDefaultDisplay();
                Point mdispcor=new Point();
                mdisp.getSize(mdispcor);
                final int xcor=mdispcor.x; //MaxX in pixels
                final int ycor=mdispcor.y; //MaxY in pixels */
                //back_img.setImageBitmap(BlurImage(bmp));
                //drawable.setAlpha(230);

                if(open==false){
                    view.setBackgroundResource(R.drawable.close);
                    anim.enterReveal(Hide_layout,design_layout);
                    open=true;
                }else{
                    anim.exitReveal(Hide_layout,design_layout);
                    view.setBackgroundResource(R.drawable.extra_butt_white);
                    open=false;
                }
            }
        });

    }

  /*  public Bitmap BlurImage(Bitmap bmp) {
        Bitmap outBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript rs = RenderScript.create(MainActivity.this);
        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation in = Allocation.createFromBitmap(rs, bmp);
        Allocation out = Allocation.createFromBitmap(rs, outBitmap);
        blur.setRadius(25.f);
        blur.setInput(in);
        blur.forEach(out);
        out.copyTo(outBitmap);
        bmp.recycle();
        rs.destroy();
        return outBitmap;
    }  */
}
