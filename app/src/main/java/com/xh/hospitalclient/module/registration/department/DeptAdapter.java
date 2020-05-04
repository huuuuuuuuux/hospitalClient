package com.xh.hospitalclient.module.registration.department;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.hospitalclient.R;
import com.xh.hospitalclient.base.BaseViewHolder;
import com.xh.hospitalclient.model.DeptBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeptAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "DeptAdapter";

    private Context context;
    private List<DeptBean> departmentList;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (context == null) {//设置上下文环境
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_dept,viewGroup,false);
        return new DeptAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (departmentList != null && departmentList.size() > 0) {
            return departmentList.size();
        } else {
            return 1;
        }
    }

    void setDeptList(List<DeptBean> departmentList) {
        this.departmentList = departmentList;
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_dept)
        TextView tvDept;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            final DeptBean department = departmentList.get(position);
            tvDept.setText(departmentList.get(position).getDeptName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent();
//                    intent.putExtra("reportDetail",report);//此处要intent传递对象必须要使该bean implements Serializable
//                    intent.setClass(context, ReportDetailActivity.class);
//                    context.startActivity(intent);

                    Log.i(TAG, "onClick: " + department.getDeptName());
                }
            });
        }

        @Override
        protected void clear() {
            tvDept.setText("");
        }
    }
}
