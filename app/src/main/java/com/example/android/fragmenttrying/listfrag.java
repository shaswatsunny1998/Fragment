package com.example.android.fragmenttrying;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class listfrag extends ListFragment {
    private Chesspiecelistener chesspiecelistener;


    public listfrag() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.family_name)));
        if(this.getActivity().findViewById(R.id.layout_default)==null) {
            chesspiecelistener.onChessPieceSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       chesspiecelistener.onChessPieceSelected(position);
    }

    public interface Chesspiecelistener
    {
        public void onChessPieceSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            chesspiecelistener=(Chesspiecelistener) context;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(context.toString()+"must implement the interface");
        }
    }
}
