package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Image_changer extends AppCompatActivity {

    int[] image  = {R.drawable.crime,R.drawable.ic_cart,R.drawable.ic_profile};
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_changer);

        ImageView imgchanger = (ImageView) findViewById(R.id.imageView);
        Button button =(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index >= image.length){
                    index=0;
                }
                imgchanger.setImageResource(image[index]);
            }
        });

    }
}