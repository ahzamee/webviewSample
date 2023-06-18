package com.webview
import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorText: MaterialTextView
    private lateinit var errorCode: MaterialTextView

    private var pageUrl: String = "YOUR_BASE_URL" //example: https://www.google.com/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVariables()
        initWebView()
        setWebClient()
        handlePullToRefresh()
        loadUrl(pageUrl)
    }

    private fun initVariables() {
        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progressBar)
        errorText = findViewById(R.id.errorText)
        errorCode = findViewById(R.id.errorCode)
    }

    private fun handlePullToRefresh() {
        // Handle pull-to-refresh functionality here
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = object : WebViewClient() {

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)

                if (error != null) {
                    webView.visibility = View.GONE
                    progressBar.visibility = View.GONE

                    errorText.visibility = View.VISIBLE
                    errorCode.visibility = View.VISIBLE
                }

                when (error?.errorCode) {
                    ERROR_HOST_LOOKUP -> {
                        errorCode.text = ErrorType.NOT_FOUND.errorCode.toString()
                        errorText.text = getString(R.string.unable_to_load_the_page)
                    }
                    ERROR_BAD_URL -> {
                        errorCode.text = ErrorType.NOT_FOUND.errorCode.toString()
                        errorText.text = getString(R.string.unable_to_load_the_page)
                    }
                    ERROR_FILE_NOT_FOUND -> {
                        errorCode.text = ErrorType.NOT_FOUND.errorCode.toString()
                        errorText.text = getString(R.string.unable_to_load_the_page)
                    }
                    ERROR_CONNECT -> {
                        errorCode.text = ErrorType.SERVICE_UNAVAILABLE.errorCode.toString()
                        errorText.text = getString(R.string.network_connection_is_not_available)
                    }
                    ERROR_TIMEOUT -> {
                        errorCode.text = ErrorType.REQUEST_TIMEOUT.errorCode.toString()
                        errorText.text = getString(R.string.unable_is_load_page_due_slow_network)
                    }
                    else -> {
                        errorCode.text = ErrorType.SYSTEM_ERROR.errorCode.toString()
                        errorText.text =
                            getString(R.string.we_are_facing_some_issue_please_contact_dev_team)
                    }
                }
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
            }
        }
    }

    private fun setWebClient() {
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progressBar.progress = newProgress
                if (newProgress < 100 && progressBar.visibility == ProgressBar.GONE) {
                    progressBar.visibility = ProgressBar.VISIBLE
                }
                if (newProgress == 100) {
                    progressBar.visibility = ProgressBar.GONE
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun loadUrl(pageUrl: String) {
        webView.loadUrl(pageUrl)
    }
}
