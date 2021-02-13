package com.techakram.maisha_info1;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Showdetail extends Fragment {
    Button btn1;
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    com.techakram.maisha_info1.models.Response response1;
    ArrayList<com.techakram.maisha_info1.models.Response> Rlist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_showdetail, container, false);
        initview(view);
        recycler();
       // response1=new com.techakram.maisha_info1.models.Response();
        Rlist=new ArrayList<com.techakram.maisha_info1.models.Response>();
        btn1.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View view)
            {
                final ProgressDialog pd = new ProgressDialog(getActivity());
                pd.setMessage("please wait..");
                pd.show();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.BaseUrl, new Response.Listener<String>( ) {
                    @Override
                    public void onResponse(String response)
                    {
                        pd.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("Response");
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jobj=jsonArray.getJSONObject(i);

                              String fname=jobj.getString("fname");
                              String lname=jobj.getString("lname");
                              String type=jobj.getString("type");
                              String number=jobj.getString("number");
                              String address=jobj.getString("address");

                                Rlist.add(new com.techakram.maisha_info1.models.Response(fname,lname,type,number,address));




                             // Log.e("checkdata",response1.getFname());
                            }

                            Log.e("data",Rlist.get(0).getFname());
                            MyAdapter adapter=new MyAdapter(getActivity(),Rlist);
                            recyclerView.setAdapter(adapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace( );
                        }
                    }
                }, new Response.ErrorListener( ) {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> mymap=new HashMap<String, String>();
                        mymap.put("email_id","interview@maishainfotech.com");

                        return mymap;
                    }
                };

                     requestQueue.add(stringRequest);
            }
        });
      return view;
    }
    private void initview(View view)
    {
        recyclerView=view.findViewById(R.id.recycler);
        btn1=view.findViewById(R.id.Show_button);
        requestQueue= Volley.newRequestQueue(getActivity());
    }
    private void recycler()
    {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}