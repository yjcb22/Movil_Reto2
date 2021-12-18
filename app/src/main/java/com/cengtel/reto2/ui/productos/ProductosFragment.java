package com.cengtel.reto2.ui.productos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.cengtel.reto2.AgregadosActivity;
import com.cengtel.reto2.R;
import com.cengtel.reto2.databinding.FragmentProductosBinding;

import java.util.HashMap;

public class ProductosFragment extends Fragment {

    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    private FragmentProductosBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProductosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int[] btnArray = {R.id.borrador_btn, R.id.lapiz_btn, R.id.cuaderno_btn,
                R.id.regla_btn, R.id.tajalapiz_btn, R.id.blog_btn};


        super.onViewCreated(view, savedInstanceState);

        for (int i=0; i < btnArray.length; i++){

            Button b = (Button) getView().findViewById(btnArray[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String producto = getResources().getResourceEntryName(v.getId()).split("_")[0];
                    int quantity = 0;
                    EditText texto;
                    if(producto.equals("borrador")){
                        texto = (EditText) getView().findViewById(R.id.editText_borrador);
                        quantity = Integer.parseInt(texto.getText().toString());
                    } else if(producto.equals("lapiz")){
                        texto = (EditText) getView().findViewById(R.id.editText_lapiz);
                        quantity = Integer.parseInt(texto.getText().toString());
                    } else if(producto.equals("cuaderno")){
                        texto = (EditText) getView().findViewById(R.id.editText_cuaderno);
                        quantity = Integer.parseInt(texto.getText().toString());
                    } else if(producto.equals("regla")){
                        texto = (EditText) getView().findViewById(R.id.editText_regla);
                        quantity = Integer.parseInt(texto.getText().toString());
                    } else if(producto.equals("tajalapiz")){
                        texto = (EditText) getView().findViewById(R.id.editText_tajalapiz);
                        quantity = Integer.parseInt(texto.getText().toString());
                    } else if(producto.equals("blog")){
                        texto = (EditText) getView().findViewById(R.id.editText_blog);
                        quantity = Integer.parseInt(texto.getText().toString());
                    }
                    inventory.put(producto,quantity);
                    Toast.makeText(getActivity().getApplicationContext(), "Producto agregado a Inventario", Toast.LENGTH_SHORT).show();


                }
            });
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent i = new Intent(getContext(), AgregadosActivity.class);
                i.putExtra("inventario",inventory);
                getActivity().startActivity(i);
                Toast.makeText(getContext(), "Productos", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}