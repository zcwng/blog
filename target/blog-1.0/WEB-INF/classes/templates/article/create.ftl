
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>写文章</title>
    <meta name="keywords" content="mtons, mtons,博客,社区,摄影,旅游,艺术,娱乐">
    <meta name="description" content="Mtons, 轻松分享你的兴趣. 便捷的文字、图片发布,扁平化的响应式设计,美观、大气,是您记录生活的最佳选择">

<meta property="mtons:mblog" content="2.2.1">

<script src="/assets/vendors/pace/pace.min.js"></script>
<link href="/assets/vendors/pace/themes/pace-theme-minimal.css" rel="stylesheet" />

<link rel='stylesheet' media='all' href='/assets/vendors/font-awesome/css/font-awesome.min.css'/>
<link rel="stylesheet" media='all' href="/assets/vendors/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" media='all' href="/assets/vendors/animate/animate.min.css">
<link rel='stylesheet' media='all' href='/assets/css/style.css'/>
<link rel='stylesheet' media='all' href='/assets/css/layout.css'/>
<link rel='stylesheet' media='all' href='/assets/css/plugins.css'/>
<link rel='stylesheet' media='all' href='/assets/css/addons.css'/>

<link rel='stylesheet' media='all' href="/assets/vendors/baguette/baguetteBox.min.css"/>

<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/assets/js/utils.js"></script>

<script type="text/javascript" src="/assets/vendors/layer/layer.js"></script>

<script type="text/javascript" src="/assets/js/sea.js"></script>
<script type="text/javascript" src="/assets/js/sea.config.js"></script>

<!-- Favicons -->
<link rel="apple-touch-icon-precomposed" href="http://mtons.com/dist/images/logo.png"/>
<link rel="shortcut icon" href="http://mtons.com/dist/images/logo.png"/>

<script type="text/javascript">
    var _base_path = '$!{base}';

    window.app = {
        base: '',
        LOGIN_TOKEN: '$!{profile.id}'
    };
	
	window.UEDITOR_HOME_URL = '/assets/vendors/ueditor/';
</script>
</head>
<body>

<#include "/inc/header.ftl">

    <!--.site-main -->
    <div class="wrap" id="wrap">
        <div class="container">
            <div class="row">
                <div class="main clearfix">
                    <div class="col-xs-12 col-md-12">
<div class="panel panel-default">
	<div class="panel-heading">
		<i class="fa fa-pencil-square"></i> 写文章
	</div>
	<div class="panel-body">
		<div id="message"></div>
		<form class="form-horizontal" action="/article/create" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">标题</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="title" maxlength="32" data-required >
				</div>
			</div>
            <div class="form-group">
                <label class="col-sm-2 control-label no-padding-right">发布到</label>
                <div class="col-sm-3">
                    <select class="form-control" name="group">
                    	<#list Application.FORUM_LIST as item>
                        <option value="${item.id}">${item.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
			<div class="form-group">
				<label for="desc" class="col-sm-2 control-label no-padding-right">内容</label>
				<input type="hidden" name="editor" value="$!{site_editor}"/>
				<div class="col-sm-8">

<textarea id="content" name="content" class="form-control" rows="5" data-required data-describedby="message" data-description="content"></textarea>

<script type="text/javascript">
function setContent(content) {
	if (content != null && content.length > 0) {
    	if (mblog.browser.ios || mblog.browser.android) {
    		$('#content').text(content);
    	} else {
    		UE.getEditor('content').setContent(content);
    	}
	}
}

$(function () {
	if (!mblog.browser.ios && !mblog.browser.android) {
        seajs.use('editor', function(editor) {
            editor.init(function () {
                $('#content').removeClass('form-control');
			});
        });
    }
})
</script>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">标签</label>
				<div class="col-sm-8">
					<input type="hidden" name="tags" id="fieldTags">
					<ul id="tags"></ul>
					<p class="help-block" style="font-size: 12px;">添加相关标签，用逗号或空格分隔 (最多4个).</p>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</form>
		<!-- /form-actions -->
	</div>
</div>

<script type="text/javascript">
seajs.use('post', function (post) {
	post.init();
});
</script>
                    </div>
                </div>
            </div>
        </div>
    </div>
<footer>
	<div class="footer-nav">
		<div class="container">
			<ul class="about-ul list-inline clearfix">
				<li><a href="/about">关于我们</a></li>
				<li><a href="/joinus">联系我们</a></li>
				<li><a href="/faqs">常见问题</a></li>
                
			</ul>
		</div>
	</div>
	<div class="container mode-link">
        <h3 class="t-h3">友情链接</h3>
        <ul class="list-inline">
            <li><a href="http://www.mtons.com" target="_blank" title="Mtons社区">Mtons社区</a></li>
        </ul>
    </div>
	<div class="container copy-right">
		<span> <a
			href="http://www.miitbeian.gov.cn/" target="_blank"></a>
		</span>
		<span class="pull-right">Powered By <a href="http://mtons.com/?copyright" target="_blank">Mtons</a></span>
	</div>

</footer>

<a href="#" class="site-scroll-top"></a>

<script type="text/javascript">
    seajs.use('main', function (main) {
        main.init();
    });
</script></body>
</html>
