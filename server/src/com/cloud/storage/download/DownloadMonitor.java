// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.storage.download;

import java.util.Map;

import com.cloud.exception.StorageUnavailableException;
import com.cloud.host.HostVO;
import com.cloud.storage.VMTemplateVO;
import com.cloud.storage.VolumeVO;
import com.cloud.storage.Storage.ImageFormat;
import com.cloud.storage.template.TemplateInfo;
import com.cloud.utils.component.Manager;

/**
 * Monitor download progress of all templates across all servers
 * @author chiradeep
 *
 */
public interface DownloadMonitor extends Manager{
	
	public boolean downloadTemplateToStorage(VMTemplateVO template, Long zoneId);
	
	public void cancelAllDownloads(Long templateId);

	public void handleTemplateSync(HostVO host);

	public boolean copyTemplate(VMTemplateVO template, HostVO sourceServer, HostVO destServer)
			throws StorageUnavailableException;

    void handleSysTemplateDownload(HostVO hostId);

    void handleSync(Long dcId);

    void addSystemVMTemplatesToHost(HostVO host, Map<String, TemplateInfo> templateInfos);

	boolean downloadVolumeToStorage(VolumeVO volume, Long zoneId, String url, String checkSum, ImageFormat format);

	void handleVolumeSync(HostVO ssHost);	

}