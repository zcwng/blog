package com.itshidu.web.service;

import com.itshidu.web.vo.Result;

public interface CommentService {

	Result save(Long articleId,Long targetCommentId,String text);

	Result list(Long articleId, int pageSize, int pn);
}
