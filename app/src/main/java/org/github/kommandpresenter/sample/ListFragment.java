package org.github.kommandpresenter.sample;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.github.kommandpresenter.PresenterFragment;
import org.github.kommandpresenter.ViewCommand;
import org.github.kommandpresenter.commands.ProgressViewCommand;
import org.github.kommandpresenter.sample.ListPresenter.Pojo;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends PresenterFragment<ListPresenter> {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().onRefresh();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    @NonNull
    @Override
    public ListPresenter createPresenter() {
        return new ListPresenter();
    }

    @Override
    public void dispatch(@NonNull ViewCommand command) {
        if (command instanceof ProgressViewCommand) {
            dispatchProgress();
        } else if (command instanceof ListPresenter.ErrorCommand) {
            dispatchError(((ListPresenter.ErrorCommand) command).error);
        } else if (command instanceof ListPresenter.PostsCommand) {
            dispatchPosts(((ListPresenter.PostsCommand) command).data);
        }
    }

    private void dispatchProgress() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                swipeRefreshLayout.setEnabled(false);
            }
        }, 300);
    }

    private void dispatchError(String message) {
        ErrorDialog dialog = ErrorDialog.newInstance(message);
        dialog.show(getFragmentManager(), "error-dialog");
    }

    private void dispatchPosts(List<Pojo> list) {
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(true);
        if (listAdapter == null) {
            listAdapter = new ListAdapter();
            recyclerView.setAdapter(listAdapter);
        }
        listAdapter.data = new ArrayList<>(list);
        listAdapter.notifyDataSetChanged();
    }

    public static class ErrorDialog extends DialogFragment {

        public static final String ERROR = "error";
        public String errorMessage;

        public static ErrorDialog newInstance(String error) {
            Bundle bundle = new Bundle();
            bundle.putString(ERROR, error);
            ErrorDialog errorDialog = new ErrorDialog();
            errorDialog.setArguments(bundle);
            return errorDialog;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            errorMessage = getArguments().getString(ERROR);
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Warning");
            builder.setMessage(errorMessage);
            builder.setPositiveButton("Ok", null);
            return builder.create();
        }
    }

    static class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

        List<Pojo> data = new ArrayList<>();

        @Override

        public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ListViewHolder holder, int position) {
            Pojo pojo = data.get(position);
            holder.textView1.setText(pojo.userId);
            holder.textView2.setText(pojo.id);
            holder.textView3.setText(pojo.title);
            holder.textView4.setText(pojo.body);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        ListViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.text1);
            textView2 = (TextView) itemView.findViewById(R.id.text2);
            textView3 = (TextView) itemView.findViewById(R.id.text3);
            textView4 = (TextView) itemView.findViewById(R.id.text4);
        }
    }
}
