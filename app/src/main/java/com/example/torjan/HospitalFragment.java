package com.example.torjan;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.torjan.Hospitals_Dashboards.getHospitalbeds;
import com.example.torjan.Hospitals_Dashboards.regional;
import com.example.torjan.Notification_Advisiroy.getAdvisory;
import com.example.torjan.Webservice.AppAPI;
import com.example.torjan.Webservice.BaseURL;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HospitalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HospitalFragment extends Fragment {

    private RecyclerView recyclerView;
    private HospitalAdapter adapter;
    private ArrayList<regional> datalist;
    private TextView txtTotalHospital,txtTotalBeds,txtRuralHospital,txtRuralBeds,txtUrbanHospital,txtUrbanBeds;
    private SearchView searchView;
    private ProgressDialog progressDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HospitalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HospitalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HospitalFragment newInstance(String param1, String param2) {
        HospitalFragment fragment = new HospitalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_hospital, container, false);

        txtTotalHospital=view.findViewById(R.id.txtTotalHospital);
        txtTotalBeds=view.findViewById(R.id.txtTotalbeds);
        txtRuralBeds=view.findViewById(R.id.txtTotalRuralbeds);
        txtUrbanBeds=view.findViewById(R.id.txtTotalUrbanbeds);
        txtRuralHospital=view.findViewById(R.id.txtTotalRuralHospital);
        txtUrbanHospital=view.findViewById(R.id.txtTotalUrbanHospital);

        recyclerView=view.findViewById(R.id.recyclerViewStates);
        searchView=view.findViewById(R.id.searchViewHospital);

        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

//        datalist=new ArrayList<>();
//
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));
//        datalist.add(new HospitalModel("Bihar","","","","","","",""));



//        adapter=new HospitalAdapter(getActivity());
//        adapter.setListStateWise(datalist);

        //recyclerView.setAdapter(adapter);

        loadHospital();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;

    }



    public void loadHospital(){
        AppAPI appAPI= BaseURL.getAPIService();
        Call<getHospitalbeds> call=appAPI.getHospitalbeds();
        call.enqueue(new Callback<getHospitalbeds>() {
            @Override
            public void onResponse(Call<getHospitalbeds> call, Response<getHospitalbeds> response) {

                txtTotalHospital.setText(response.body().getData().getSummary().getTotoalBeds());
                txtTotalBeds.setText((response.body().getData().getSummary().getTotoalBeds()));
                txtRuralBeds.setText(response.body().getData().getSummary().getRuralBeds());
                txtUrbanBeds.setText(response.body().getData().getSummary().getUrbanBeds());
                txtRuralHospital.setText(response.body().getData().getSummary().getRuralHospitals());
                txtUrbanHospital.setText(response.body().getData().getSummary().getUrbanHospitals());

                progressDialog.dismiss();

                datalist=new ArrayList<>();
                datalist=response.body().getData().getRegional();
                if(datalist.size()>0) {
                    adapter = new HospitalAdapter(getActivity());
                    adapter.setListStateWise(datalist);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    Log.i("djasjhfdaskjdhask", "" + datalist.size());
                }
            }

            @Override
            public void onFailure(Call<getHospitalbeds> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("error",t.getCause().toString());
            }
        });
    }

}