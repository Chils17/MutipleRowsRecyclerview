package demo.webmyne.com.mutiplerowsrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by vaibhavirana on 28-03-2017.
 */

public class CustomAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<User> mObjects;


    public static final int Row = 0;
    public static final int Col = 1;
    //public static final int USER = 2;

    public CustomAdaptor(Context mContext, List<User> mObjects) {
        this.mContext = mContext;
        this.mObjects = mObjects;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0)
            return Row;
        else
            return Col;
        //else if (mObjects.get(position) instanceof User)
          //  return USER;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case Row:
                View itemView0 = inflater.inflate(R.layout.item_row, parent, false);
                return new RowViewHolder(itemView0);
            case Col:
                View itemView1 = inflater.inflate(R.layout.item_column, parent, false);
                return new ColumnViewHolder(itemView1);

            default:
                View itemView11 = inflater.inflate(R.layout.item_row, parent, false);
                return new RowViewHolder(itemView11);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        User user = mObjects.get(position);
        switch (getItemViewType(position)) {
            case Row:
                RowViewHolder rowViewHolder  = (RowViewHolder) holder;
                rowViewHolder.imageView.setImageResource(user.getImage());
                rowViewHolder.textName.setText(user.getName());
                rowViewHolder.textCity.setText(user.getCity());
                break;
            case Col:
                ColumnViewHolder columnViewHolder  = (ColumnViewHolder) holder;
                columnViewHolder.imgView.setImageResource(user.getImage());
                columnViewHolder.txtName.setText(user.getName());
                columnViewHolder.txtCity.setText(""+user.getCity());
                break;
            /*case USER:
                User user = (User) mObjects.get(position);
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.tvName.setText(user.getName());
                userViewHolder.tvAddess.setText(user.getAddress());
                break;*/
        }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

  /*  public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvAddess;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAddess = (TextView) itemView.findViewById(R.id.tv_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User user = (User) mObjects.get(getAdapterPosition());
                    Toast.makeText(mContext, user.getName() + ", " + user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }*/

    public class RowViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textName;
        private TextView textCity;

        public RowViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textCity = (TextView) itemView.findViewById(R.id.textCity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public class ColumnViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;
        private TextView txtName;
        private TextView txtCity;

        public ColumnViewHolder(View itemView) {
            super(itemView);
            imgView= (ImageView) itemView.findViewById(R.id.imgView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
