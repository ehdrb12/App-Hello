package com.human.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import core.AsyncResponse;
import core.JsonConverter;
import core.PostResponseAsyncTask;

public class SubActivity extends AppCompatActivity {
    private RecyclerAdapter mRecyclerAdapter;
    private List mItemList = new ArrayList<MemberVO>();//RestAPI 결과 저장객체
    //어댑터에서 선택한 값확인 변수
    private int currentCursorId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //객체 생성
        mRecyclerAdapter = new RecyclerAdapter(mItemList);
        //리사이클러뷰xml과 어댑터 바인딩(attach) No adapter attached
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);//리사이클러 뷰의 높이를 고정한다.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mRecyclerAdapter);//실제 attach(바인딩)

        getAllData();
    }

    //셀렉트 쿼리결과를 리턴합니다.
    private void getAllData() {
        String requestUrl ="http://192.168.123.66:8080/android/list";
        HashMap postDataParams = new HashMap();
        postDataParams.put("mobile", "android");
        List resultList = new ArrayList<>();//RestAPI jsonData 내용이 담을 예정.
        PostResponseAsyncTask readTask = new PostResponseAsyncTask(SubActivity.this, postDataParams, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Toast.makeText(SubActivity.this, s+"디버그", Toast.LENGTH_LONG).show();
                ArrayList<MemberVO> memberList = //Json result 값을 MemberVO클래스에 매핑하면서 memberList에 입력
                        new JsonConverter<MemberVO>().toArrayList(s, MemberVO.class);
                for(MemberVO value: memberList){ //memberList에서 개별 값 매핑하면서 names에 입력
                    //tableList 리스트객체에 1레코드씩 저장
                    String p_id = value.user_id;
                    String p_name = value.user_name;
                    String p_email = value.email;
                    //매개변수가 없는 클래스의 생성자 메서드는 자바가 자동으로 만둘어줌.
                    resultList.add(new MemberVO(p_id,p_name,p_email));
                }
                //화면출력
                mItemList.clear();
                mItemList.addAll(resultList);
                mRecyclerAdapter.notifyDataSetChanged();//어댑터에 실제값이 들어가면서 화면에 뿌려짐
            }
        });
        readTask.execute(requestUrl);
    }
}