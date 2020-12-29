package com.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.ReplyVO;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;

	//댓글 조회

	//댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(ReplyVO vo) throws Exception {
		System.out.println("rvo.getBno(): " + vo.getBno());
		replyService.write(vo);

		return "redirect:/board/view?bno=" + vo.getBno();

	}

	//댓글 수정

	//댓글 삭제
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String getDelete(ReplyVO vo) throws Exception {
		System.out.println("rvo.getBno(): " + vo.getBno());
		replyService.delete(vo);

//		return "redirect:/board/view?rno=" + vo.getRno();
//		return "/board/view?bno=" + rvo.getBno();
		System.out.println("rvo.getBno(): " + vo.getBno());

		return "redirect:/board/view?bno=" + vo.getBno();
	}


}
