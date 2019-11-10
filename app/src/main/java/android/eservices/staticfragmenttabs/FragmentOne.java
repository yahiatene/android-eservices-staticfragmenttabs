package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class FragmentOne extends Fragment {

    static final String TAB_NAME = "ADD";
    private SharedViewModel model;

    public FragmentOne() { }

    static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Button button = view.findViewById(R.id.button_increment);
        // holds instance of SharedViewModel
        model =
                ViewModelProviders
                        .of(getActivity())
                        .get(SharedViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLiveData();
            }});
        return view;
    }

    // updates liveData from model
    private void updateLiveData(){
        Integer value =  model
                .getLiveData()
                .getValue();

        if(null != value) {
            model.getLiveData().setValue(++value);
        }
        if(null == value){
            model.getLiveData().setValue(0);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
