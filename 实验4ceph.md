# Ceph的安装和实践

## CEPH的部署安装

####  增加ceph的源 

```
vim /etc/yum.repos.d/ceph.repo

[ceph]
name=ceph
baseurl=http://mirrors.163.com/ceph/rpm-jewel/el7/x86_64/
gpgcheck=0
[ceph-noarch]
name=cephnoarch
baseurl=http://mirrors.163.com/ceph/rpm-jewel/el7/noarch/
gpgcheck=0
```

####  安装`ceph-deploy`： 

```
sudo yum install ceph-deploy
```

### 安装SSH服务器

#### 对于**所有** Ceph节点，请执行以下步骤：

#### 在每个Ceph节点上安装SSH服务器：

```
sudo yum install openssh-server
```

### 创建一个CEPH部署用户

1.生成SSH密钥，但不使用`sudo`或 `root`用户。将密码短语留空：

```
ssh - keygen
```

2.将密钥复制到每个Ceph节点的用户名替换。 

```
ssh-copy-id Ceph节点IP
```



#### 1.创建集群

ceph-deploy new {initial-monitor-node(s)}

####  2.将Ceph配置文件中的默认副本数从更改为 `3`，`2`以便Ceph可以仅使用两个Ceph OSD 来达到一种状态。在该部分下添加以下行：`active + clean``[global]`

#### 3.安装Ceph。

```
ceph-deploy install admin-node node2 node3 node4
```

#### 4.添加初始监视器并收集密钥： 

```
ceph-deploy mon create-initial
```