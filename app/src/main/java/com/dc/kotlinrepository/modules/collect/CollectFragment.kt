package com.dc.kotlinrepository.modules.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.adapter.CollectAdapter
import com.dc.kotlinrepository.base.BaseFragment
import com.dc.kotlinrepository.databse.Student
import com.dc.kotlinrepository.modules.collect.inter.CollectPresenter
import com.dc.kotlinrepository.modules.collect.inter.CollectView
import kotlinx.android.synthetic.main.fragment_collect.*

class CollectFragment : BaseFragment<CollectPresenter>(), CollectView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View? = inflater.inflate(R.layout.fragment_collect, container, false)
        return root ?:   /* root null  就用后面的 */    super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData.setOnClickListener {
            val names = arrayOf(
                "乔峰",
                "段誉",
                "虚竹",
                "慕容复",
                "张三",
                "李四",
                "王五",
                "赵六",
                "初七",
                "杜子腾",
                "王小二",
                "李大奇"
            )
            val ages = arrayOf(
                43,
                24,
                19,
                83,
                64,
                21,
                56,
                32,
                17,
                32,
                45,
                14
            )
            for (index in names.indices) {
                val student = Student(names[index], ages[index])
                presenter.insert(student)
            }
        }

        clearData.setOnClickListener {
            presenter.deleteAll()
        }

    }

    override fun getPresent(): CollectPresenter = CollectPresenterImpl(this)

    override fun createOk() {
        presenter.queryAll()
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun showResultSuccess(result: List<Student>?) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = CollectAdapter(result)
        recyclerView.adapter = adapter
    }

    override fun showResult(result: Boolean) {
        if (result)
            presenter.queryAll()
    }
}