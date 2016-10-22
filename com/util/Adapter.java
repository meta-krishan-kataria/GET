package com.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.model.Tag;

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
		issueVO.setCreatedBy( issue.getCreatedBy().getName() );
		issueVO.setCreater( issue.getCreatedBy().getName() );
		issueVO.setCreatedOn( issue.getCreatedOn().toString() );
		issueVO.setDepartmentName( issue.getDepartment().getDepartmentName() );
		issueVO.setDepartmentId( issue.getDepartment().getId()  );
		issueVO.setBody( issue.getBody()  );
		issueVO.setCurrentStatus( issue.getCurrentStatus() );
		issueVO.setPriority( issue.getPriority() );
		if( issue.getTargetResolutionDate() != null ){
			issueVO.setTargetResolutionDate(  issue.getTargetResolutionDate().toString() );
		}
		if( issue.getActualResolutionDate() != null ){
			issueVO.setActualResolutionDate(  issue.getActualResolutionDate().toString());
		}
		
		Set<String> tagString=new HashSet<String>();
		Set<Tag> tags=issue.getTags();
		if( issue.getTags() != null ){
			
			
			for( Tag tag : tags ){
				tagString.add( tag.getTagTitle() );
			}
		}
		issueVO.setTags( tagString );
		
		
		List<Integer> resolverIdList=new ArrayList<Integer>();
		List<UserDetails> resolvers=issue.getResolvers();
		if( issue.getResolvers() != null ){
			
			
			for( UserDetails resolver : resolvers ){
				resolverIdList.add( resolver.getId() );
			}
		}
		issueVO.setResolvers(resolverIdList);
		
		
		
		List<String> resolverNamesList=new ArrayList<String>();
		List<UserDetails> resolverNames=issue.getResolvers();
		if( issue.getResolvers() != null ){
			
			
			for( UserDetails resolver : resolvers ){
				resolverNamesList.add( resolver.getName() );
			}
		}
		issueVO.setResolverNames(resolverNamesList);
		
		
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

		resolverVO.setId( userDetails.getId() );
		resolverVO.setName( userDetails.getName() );
		resolverVO.setDepartmentId( userDetails.getDepartment().getId() );
		
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
