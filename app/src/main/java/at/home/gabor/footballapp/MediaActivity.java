package at.home.gabor.footballapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MediaActivity extends AppCompatActivity {

    private ViewPager viewPager;
    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        TabLayout tabLayout = findViewById(R.id.tabLayoutMedia);
        TabItem tab1 = findViewById(R.id.tabMediaFotos);
        TabItem tab2 = findViewById(R.id.tabMediaVideos);
        viewPager = findViewById(R.id.viewPagerMedia);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMain:
                Intent intent0 = new Intent(this, MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.itemEra:
                Intent intent = new Intent(this, EraActivity.class);
                startActivity(intent);
                break;
            case R.id.itemTop5:
                Intent intent2 = new Intent(this, TopActivity.class);
                startActivity(intent2);
                break;
            case R.id.itemMedia:
                Intent intent3 = new Intent(this, MediaActivity.class);
                startActivity(intent3);
                break;
            case R.id.itemQuiz:
                Intent intent4 = new Intent(this, QuizActivity.class);
                startActivity(intent4);
                break;

        }
        return true;
    }

    int imageSource;
    public void setPic1(View view) {
        imageSource = R.drawable.gallery1;
        startPicActivity(imageSource);
    }
    public void setPic2(View view) {
        imageSource = R.drawable.gallery2;
        startPicActivity(imageSource);
    }
    public void setPic3(View view) {
        imageSource = R.drawable.gallery3;
        startPicActivity(imageSource);
    }
    public void setPic4(View view) {
        imageSource = R.drawable.gallery4;
        startPicActivity(imageSource);
    }
    public void setPic5(View view) {
        imageSource = R.drawable.gallery5;
        startPicActivity(imageSource);
    }
    public void setPic6(View view) {
        imageSource = R.drawable.gallery6;
        startPicActivity(imageSource);
    }

    public void startPicActivity(int imageSource) {
        Intent intent = new Intent(this, FullscreenActivity.class);
        intent.putExtra("ImageToShow", imageSource);
        startActivity(intent);
    }



}
