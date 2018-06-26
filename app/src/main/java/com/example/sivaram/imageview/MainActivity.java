package com.example.sivaram.imageview;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.View.OnTouchListener;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    PhotoViewAttacher p;
    private ViewGroup rootlayout;
    private int x;
    private int y;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // rootlayout=findViewById(R.id.viewroot);
        imageView=findViewById(R.id.iv);
       // RelativeLayout.LayoutParams layoutParams =new RelativeLayout.LayoutParams(150,150);
       // imageView.setLayoutParams(layoutParams);
       // imageView.setOnTouchListener(new ChoiceToughListener());
        p=new PhotoViewAttacher(imageView);//Here i am using photo view library for zooming purpose
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {//here i rotate the image view
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation()+90);
            }
        });
        //imageView.setOnTouchListener(new choice());

    }
    private final class choice implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if((motionEvent.getAction() == MotionEvent.ACTION_DOWN) && ((ImageView)view).getDrawable()!=null){
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder =new View.DragShadowBuilder(view);
                view.startDrag(data,shadowBuilder,view,0);
                return true;
            }
            else {
                return false;
            }
        }
    }
    /*private final class ChoiceToughListener implements OnTouchListener{
        public boolean onTouch(View view, MotionEvent event){
            final int X=(int) event.getRawX();
            final int Y=(int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lparams =(RelativeLayout.LayoutParams) view.getLayoutParams();
                    x=X-lparams.leftMargin;
                    y=Y-lparams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin=X-x;
                    layoutParams.topMargin=Y-y;
                    layoutParams.rightMargin=-250;
                    layoutParams.bottomMargin=-250;
                    view.setLayoutParams(layoutParams);
                    break;


            }
            rootlayout.invalidate();
            return true;
        }

    }*/
}
