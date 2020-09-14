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

import com.example.torjan.Hospitals_Dashboards.getHospitalbeds;
import com.example.torjan.Hospitals_Dashboards.getMedicalcollegeBeds;
import com.example.torjan.Hospitals_Dashboards.medicalColleges;
import com.example.torjan.Webservice.AppAPI;
import com.example.torjan.Webservice.BaseURL;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicalCollegeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicalCollegeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CollegesAdapter adapter;
    private ArrayList<medicalColleges> datalist;
    private SearchView searchView;
    private ProgressDialog progressDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MedicalCollegeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicalCollegeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicalCollegeFragment newInstance(String param1, String param2) {
        MedicalCollegeFragment fragment = new MedicalCollegeFragment();
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
        View view=inflater.inflate(R.layout.fragment_medical_college, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewColleges);
        searchView=view.findViewById(R.id.searchViewMedicalColleges);

        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
//        datalist=new ArrayList<>();
//
//        datalist.add(new CollegesModel("A & N Islands","Andaman & Nicobar Islands Insitute of Medical Sciences, Port Blair","port blair","govt","150","500"));
//        datalist.add(new CollegesModel("","","","","",""));
//        datalist.add(new CollegesModel("","","","","",""));
//        datalist.add(new CollegesModel("","","","","",""));
//        datalist.add(new CollegesModel("","","","","",""));
//        datalist.add(new CollegesModel("","","","","",""));
//        datalist.add(new CollegesModel("","","","","",""));


//        adapter=new CollegesAdapter(getActivity());
//        adapter.setListCollegeWise(datalist);
//
//        recyclerView.setAdapter(adapter);

        loadMedicalColleges();

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

    public void loadMedicalColleges(){
        AppAPI appAPI= BaseURL.getAPIService();
        Call<getMedicalcollegeBeds> call=appAPI.getMedicalcollegeBeds();
        call.enqueue(new Callback<getMedicalcollegeBeds>() {
            @Override
            public void onResponse(Call<getMedicalcollegeBeds> call, Response<getMedicalcollegeBeds> response) {

                progressDialog.dismiss();

                datalist=new ArrayList<>();
                datalist=response.body().getData().getMedicalColleges();
                if(datalist.size()>0) {
                    adapter = new CollegesAdapter(getActivity());
                    adapter.setListCollegeWise(datalist);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    Log.i("djasjhfdaskjdhask", "" + datalist.size());
                }
            }

            @Override
            public void onFailure(Call<getMedicalcollegeBeds> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("error",t.getCause().toString());
            }
        });
    }

}