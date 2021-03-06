package demo.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import demo.entity.Vote;
import demo.interfac.VoteBiz;

public class VoteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private VoteBiz voteBiz;
	private Vote vote;

	public void setVoteBiz(VoteBiz voteBiz) {
		this.voteBiz = voteBiz;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public String queryvote() {
		List<Vote> list = voteBiz.findAll();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}

	public String addvote() {
		Vote v = new Vote();
		v.setVoteid(voteBiz.getNewId());
		v.setUserid(vote.getUserid());
		v.setTitle(vote.getTitle());
		v.setQuestion(vote.getQuestion());
		v.setClassification(vote.getClassification());
		v.setPublishdate(vote.getPublishdate());
		v.setFinishdate(vote.getFinishdate());
		v.setAvaliable(new Long(1));
		voteBiz.addVote(v);

		List<Vote> list = voteBiz.findAll();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}

	public String mergevote() {
		Vote v = new Vote();
		v = voteBiz.getById(vote.getVoteid());
		ActionContext.getContext().put("v", v);
		return SUCCESS;
	}

	public String savemerge() {
		Vote vo = new Vote();
		vo = voteBiz.getById(vote.getVoteid());
		vo.setUserid(vote.getUserid());
		vo.setTitle(vote.getTitle());
		vo.setQuestion(vote.getQuestion());
		vo.setClassification(vote.getClassification());
		vo.setPublishdate(vote.getPublishdate());
		vo.setFinishdate(vote.getFinishdate());
		voteBiz.mergeVote(vo);

		List<Vote> list = voteBiz.findAll();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}

	public String deletevote() {
		Vote v = new Vote();
		v = voteBiz.getById(vote.getVoteid());
		voteBiz.deleteVote(v);

		List<Vote> list = voteBiz.findAll();
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}
}