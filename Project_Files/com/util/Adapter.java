package com.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Issue;
import com.model.IssueVO;
import com.model.ResolverVO;
import com.model.UserDetails;

@Component
public class Adapter {
	
	public IssueVO convertToVO(Issue issue){
		
		IssueVO issueVO=new IssueVO();
		issueVO.setId( issue.getId() );
		issueVO.setTitle( issue.getTitle() );
		issueVO.setCreatedBy( issue.getCreatedBy().getId() + "" );
		issueVO.setCreater( issue.getCreatedBy().getName() );
		issueVO.setCreatedOn( issue.getCreatedOn().toString() );
		issueVO.setDepartmentName(issue.getDepartment().getDepartmentName());
		issueVO.setBody( issue.getBody()  );
		issueVO.setCurrentStatus( issue.getCurrentStatus() );
		issueVO.setPriority( issue.getPriority() );
	/*	issueVO.setTargetResolutionDate(issue.getTargetResolutionDate()?"" );
		issueVO.setActualResolutionDate( issue.getActualResolutionDate().toString() );*/
		//issueVO.setTags(tags);
		//issueVO.setResolvers(resolvers);
		return issueVO;
		
	}
	
	public List<IssueVO> convertToVO(List<Issue> issueList){
		
		List<IssueVO> issueVOList=new ArrayList<IssueVO>();
		
		for(Issue issue : issueList  ){
			issueVOList.add( convertToVO( issue ) );
		}
		return issueVOList;
	}
	
	
	public ResolverVO convertToResolverVO( UserDetails userDetails){
		
		ResolverVO resolverVO=new ResolverVO();
		
		
		resolverVO.setName( userDetails.getName() );
		
		return resolverVO;
	}
	
	
public List<ResolverVO> convertToResolverVO( List<UserDetails> userDetailsList){
		
	List<ResolverVO> resolverVOList=new ArrayList<ResolverVO>();
	
	for(UserDetails userDetails : userDetailsList  ){
		resolverVOList.add( convertToResolverVO( userDetails ) );
	}
	return resolverVOList;
	}
	
}
