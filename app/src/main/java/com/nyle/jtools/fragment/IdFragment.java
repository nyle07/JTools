package com.nyle.jtools.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nyle.jtools.R;
import com.nyle.jtools.httpdata.BankBean;
import com.nyle.jtools.httpdata.IdBean;

/**
 * Created by NYL on 2017/3/7 0007.
 * Email:1174212579@qq.com
 */

public class IdFragment extends BaseFragment {

    private EditText editText;
    private Button button;
    private RequestQueue mQueue;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private EditText editText2;
    private Button button2;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private Gson gson;
    private final String url = "http://api.avatardata" +
            ".cn/IdCard/LookUp?key=7d73a22aef344524a8c61682465618e3&id=";
    private final String url2 = "http://api.avatardata" +
            ".cn/Bank/Query?key=e587e83f6db74987bbfdb962c492a60d&cardnum=";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.id_main, container, false);


        editText = (EditText) view.findViewById(R.id.editText);
        button = (Button) view.findViewById(R.id.button);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        editText2 = (EditText) view.findViewById(R.id.editText2);
        button2 = (Button) view.findViewById(R.id.button2);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        textView7 = (TextView) view.findViewById(R.id.textView7);

        mQueue = Volley.newRequestQueue(getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = editText.getText().toString();
                String query = url + num;
                Log.d("TAG", query);
                readResult1(query);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = editText2.getText().toString();
                String query = url2 + num;
                Log.d("TAG", query);
                readResult2(query);
            }
        });

        return view;
    }

    private void readResult2(String url) {
        StringRequest request =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                gson=new Gson();
                BankBean bankBean=gson.fromJson(response,BankBean.class);
                BankBean.ResultBean resultBean=bankBean.getResult();
                if (bankBean.getError_code()!=1){
                textView5.setText(resultBean.getBankname());
                textView6.setText(resultBean.getCardname());
                textView7.setText(resultBean.getCardtype());}
                else {
                    Snackbar.make(getActivity().findViewById(R.id.fragment_container),"请检查是否输入有误",Snackbar.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(request);
    }

    private void readResult1(String url) {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response
                .Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.d("tag", response);
                gson = new Gson();
                IdBean idBean = gson.fromJson(response, IdBean.class);
                IdBean.ResultBean resultBean = idBean.getResult();

                if (idBean.getError_code()!=1){
                textView2.setText(resultBean.getAddress());
                textView3.setText(resultBean.getSex());
                textView4.setText(resultBean.getBirthday());}
                else {
                    Snackbar.make(getActivity().findViewById(R.id.fragment_container),"请检查是否输入有误",Snackbar.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(request);
    }
}
