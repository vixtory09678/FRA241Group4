package com.example.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.R;
import com.example.fragment.dao.Update;
import com.example.fragment.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class ThirdFragment extends Fragment implements View.OnClickListener {

    Button sendButton;
    EditText comment;
    TextView sampleComment;
    public ThirdFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static ThirdFragment newInstance() {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        sampleComment = (TextView) rootView.findViewById(R.id.sampleComment);
        comment = (EditText) rootView.findViewById(R.id.comment);
        sendButton = (Button) rootView.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(ThirdFragment.this);

        comment.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    //copy text to show on textView
                    sampleComment.setText(comment.getText());
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sendButton)
        {
            sampleComment.setText(comment.getText());

            Update object = new Update ("CQ0CIKNV5SONBQS3",comment.getText().toString());
            Call<Update> call = HttpManager.getInstance().getService().sendFeedback(object);

            Toast.makeText(getContext(),"api_key=CQ0CIKNV5SONBQS3&field1="+comment.getText().toString(),Toast.LENGTH_SHORT).show();
            call.enqueue(new Callback<Update>() {
                @Override
                public void onResponse(Call<Update> call, Response<Update> response) {
                    if(response.isSuccessful()){
                        Log.e("Raw data",response.raw().toString());
                    }else{
                        Log.e("Fail","Load fail fuckyou"+response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<Update> call, Throwable t) {
                    Log.e("Sync fail","fuckyou sync fail");
                }
            });
            comment.setText("");
        }

    }
}
