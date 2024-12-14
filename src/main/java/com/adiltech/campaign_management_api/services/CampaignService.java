package com.adiltech.campaign_management_api.services;

import com.adiltech.campaign_management_api.entities.Campaign;
import com.adiltech.campaign_management_api.repositories.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long id, Campaign updatedCampaign) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Campaign not found"));
        campaign.setName(updatedCampaign.getName());
        campaign.setStartDate(updatedCampaign.getStartDate());
        campaign.setEndDate(updatedCampaign.getEndDate());
        campaign.setBudget(updatedCampaign.getBudget());
        campaign.setStatus(updatedCampaign.getStatus());
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
