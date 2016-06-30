package com.kevin.zwk.recyclerview_demo_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * <p/>
 * 项目名称：kt_0629_1
 * 包名称：com.kevin.zwk.recyclerview_demo_1
 * 类描述：MyRecyclerview适配器
 * 创建人：Zhang Wenkai
 * 创建时间：2016/6/29 16:36
 * 修改人：Zhang Wenkai
 * 修改时间：
 * 修改备注：
 */
public class MyRecyclerview extends RecyclerView.Adapter<MyRecyclerview.MyViewHolder> {
    private List<String> list;
    private ItemClickListener listener;
    private Context context;


    interface ItemClickListener {
        void onTextClick(View view, int position);

        void onItemClick(View view, int position);
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }


    public MyRecyclerview(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(convertView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点击了" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    listener.onItemClick(v, getLayoutPosition());
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点击了item" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                    listener.onTextClick(v, getLayoutPosition());

                }
            });

        }
    }
}
