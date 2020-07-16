package com.kosmo.a24listview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO61";

    String[] idolGroup = { "엑소1", "방탄소년단1", "워너원1", "뉴이스트1", "갓세븐1", "비투비1", "빅스1",
            "엑소2", "방탄소년단2", "워너원2", "뉴이스트2", "갓세븐2", "비투비2", "빅스2",
            "엑소3", "방탄소년단3", "워너원3", "뉴이스트3", "갓세븐3", "비투비3", "빅스3" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 리스트뷰의 데이터로 사용 할 어댑터 객체 생성 및 배열설정
        /*
        형식 : ArrayAdapter<>(컨텍스트, 리스트뷰의 모양, 데이터(배열 or JSON))
         */
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, idolGroup);

        // 2. 리스트뷰 위젯을 가져와서 객체화
        ListView listView1 = findViewById(R.id.listView1);

        // 3. 리스트뷰에 어댑터 설정
        listView1.setAdapter(adapter);

        // 4. 리스트뷰에 리스너 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /*
                특정항목 클릭 시 해당 항목의 index값이 콜백메소드로 전달됨.
                여기서는 매개변수 i를 사용
                 */
                Log.i(TAG, "선택한 index : " + i);
                Toast.makeText(getApplicationContext(),
                        idolGroup[i] + " 선택됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
