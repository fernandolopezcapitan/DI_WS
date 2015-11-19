package salesianostriana.com.di.talkme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created flopez on 19/11/15.
 */

    public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosViewHolder> {
        private ArrayList<Usuarios_item> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class UsuariosViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView usuario;

            public UsuariosViewHolder(View v) {

                super(v);

                usuario = (TextView)v.findViewById(R.id.tv_usuario);

            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public UsuariosAdapter(ArrayList<Usuarios_item> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public UsuariosViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_usuarios, parent, false);
            // set the view's size, margins, paddings and layout parameters

            UsuariosViewHolder vh = new UsuariosViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(UsuariosViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            holder.usuario.setText(mDataset.get(position).getUsuarios());

            // Aqui crear funcionalidad con un (boton) setOnClickListener que mande un intent
            // y que abra un nuevo activity (MandarMensaje.class) y añadiendole un put extra
            // en ese put extra adjuntar el "usuario".

            // Recoger en el OnCreate del MandarMensaje el extra "usuario"
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

