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

1.生成SSH密钥：

```
ssh - keygen
```

![1](https://github.com/czl233456/CHENZL/blob/master/%E5%AE%9E%E9%AA%8C4/image4/1.png)

2.配置ssh的config

![2](https://github.com/czl233456/CHENZL/blob/master/%E5%AE%9E%E9%AA%8C4/image4/2.png)

3.将密钥复制到每个Ceph节点的用户名替换。 

```
ssh-copy-id Ceph节点IP
```

![3](https://github.com/czl233456/CHENZL/blob/master/%E5%AE%9E%E9%AA%8C4/image4/3.png)



#### 1.创建集群

ceph-deploy new 

####  2.修改mon节点主机名为mon

```
hostnamectl set-hostname mon1
```

#### 3.安装Ceph。

```
ceph-deploy install admin-node osd1 osd2 mon1
```

#### 4.初始化mon1节点 

```
ceph-deploy mon create-initial
```

![ceph1687_WPS图片](https://github.com/czl233456/CHENZL/blob/master/%E5%AE%9E%E9%AA%8C4/image4/4.png)

```
ceph-deploy gatherkeys mon1
```

![5](https://github.com/czl233456/CHENZL/blob/master/%E5%AE%9E%E9%AA%8C4/image4/5.png)

