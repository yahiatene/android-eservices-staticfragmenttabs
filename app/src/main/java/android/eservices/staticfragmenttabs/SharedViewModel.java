package android.eservices.staticfragmenttabs;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> liveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getLiveData() {
        return liveData;
    }
}